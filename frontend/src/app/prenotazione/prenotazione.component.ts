import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ServizioApiService } from '../servizi/servizio-api.service';

@Component({
  selector: 'app-prenotazione',
  templateUrl: './prenotazione.component.html',
  styleUrls: ['./prenotazione.component.css'],
})
export class PrenotazioneComponent implements OnInit {

  myForm: FormGroup;
  records: any;
  selectedTime: string | undefined
  times: string[] = [];

  animal: string;
  name: string;

  nome!: string;
  cognome!: string;
  codiceFiscale!: string;
  searchResults: any[] = [];

  visibleLista = false;

  displayedColumns: string[] = ['nome', 'cognome','dataNascita','codiceFiscale'];

  constructor(
    private servizioApi: ServizioApiService,
    private datePipe: DatePipe,
    private formBuilder: FormBuilder,) {
      this.myForm = this.formBuilder.group({
        dataprenotazione: ['', Validators.required],
        oraprenotazione: ['', Validators.required],
        codiceprestazione: ['', [Validators.required]],
        idpaziente: ['', [Validators.required]],
        datacontatto: ''
      });
    }

  ngOnInit() {
    this.generateTimes();
  }

  inserisciPrenotazione() {
    let yourDate = new Date()
    this.myForm.setValue({
      codiceprestazione: this.myForm.value.codiceprestazione,
      idpaziente: this.myForm.value.idpaziente,
      dataprenotazione: this.datePipe.transform(this.myForm.value.dataprenotazione, "yyyyMMdd"),
      datacontatto: this.datePipe.transform(yourDate, "yyyyMMdd"),
      oraprenotazione: this.myForm.value.oraprenotazione,
    });
    this.servizioApi.addPrenotazione(this.myForm.value).subscribe((ritorno: any[]) => {
      console.log(ritorno);
    });
  }

  generateTimes() {
    const startTime = 0; // Inizio giornata in minuti (mezzanotte)
    const endTime = 24 * 60; // Fine giornata in minuti (mezzanotte del giorno successivo)
    const interval = 30; // Intervallo di 30 minuti

    for (let minutes = startTime; minutes < endTime; minutes += interval) {
      const hours = Math.floor(minutes / 60);
      const mins = minutes % 60;
      const formattedTime = this.formatTime(hours, mins);
      this.times.push(formattedTime);
    }
  }

  formatTime(hours: number, mins: number): string {
    const formattedHours = ('0' + hours).slice(-2);
    const formattedMins = ('0' + mins).slice(-2);
    return `${formattedHours}:${formattedMins}`;
  }

  apriRicercaPazienti(event: MouseEvent) {
    const paragraphText = (event.target as HTMLParagraphElement).textContent;
    if (paragraphText == 'search') {
      this.visibleLista = !this.visibleLista;
    }
  }
  apriListaTimeout() {
    setTimeout(() => {
      // La funzione che vuoi eseguire con un ritardo di 1 secondo
      this.apriLista();
    }, 1000);
  }

  ricerca() {
    const params = {nome:"",
    cognome: "",
    codiceFiscale: ""
    };
    if (this.nome) {
      params['nome'] = this.nome;
    }
    if (this.cognome) {
      params['cognome'] = this.cognome;
    }
    if (this.codiceFiscale) {
      params['codiceFiscale'] = this.codiceFiscale;
    }
    this.servizioApi.getPaziente(params['nome'], params['cognome'], params['codiceFiscale']).subscribe(
      (lista) => {
        this.searchResults = lista;
        console.log(lista)
      },
      (error) => {
        console.error('Errore nella ricerca:', error);
      }
    );
  }

  apriLista() {
    this.visibleLista = !this.visibleLista;
  }

}
