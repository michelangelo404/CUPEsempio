import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ServizioApiService } from '../servizi/servizio-api.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-lista-pazienti',
  templateUrl: './lista-pazienti.component.html',
  styleUrls: ['./lista-pazienti.component.css'],
})
export class ListaPazientiComponent implements OnInit {

  records: any;

  nome!: string;
  cognome!: string;
  codiceFiscale!: string;

  displayedColumns: string[] = ['nome', 'cognome','dataNascita','codiceFiscale', 'actions'];
  dataSource = [
    { nome: 'valore1', cognome: 'valore2', dataNascita: 'valore3', codiceFiscale: 'valore4' }]

  constructor(
    private servizioApi: ServizioApiService,
    private formBuilder: FormBuilder,
    private datePipe: DatePipe,) {
    }

  ngOnInit() {
  }

  onClick(element: any) {
    // Azione da eseguire quando il pulsante viene premuto
    console.log('Valore preso:', element.col1); // Esempio: stampa il valore della colonna 1
  }

}
