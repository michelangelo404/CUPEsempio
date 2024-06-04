import { Component, OnInit } from '@angular/core';
import { ServizioApiService } from '../servizi/servizio-api.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css'],
})
export class ListaComponent implements OnInit {
  records: any;

  constructor(private servizioApi: ServizioApiService,
    private datePipe: DatePipe,) { }

  displayedColumns: string[] = ['nome', 'cognome','dataNascita'];

  ngOnInit(): void {
    this.servizioApi.getPrenotazioni().subscribe((lista: any) => {
      this.records = lista.data;
    },
      (error) => {
        console.error('Errore durante il recupero dei record', error);
      }
    );
  }

}

