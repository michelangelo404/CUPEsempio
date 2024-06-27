import { Component, OnInit } from '@angular/core';
import { ServizioApiService } from '../servizi/servizio-api.service';
import { DatePipe } from '@angular/common';
import { MatTableDataSource } from '@angular/material/table';

interface Prenotazione {
  dataprenotazione: string;
  oraprenotazione: string;
  datacontatto: string;
  codiceprestazione: string;
  idpaziente: string;
}

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css'],
})
export class ListaComponent implements OnInit {

  constructor(private servizioApi: ServizioApiService,
    private datePipe: DatePipe,) { }

  displayedColumns: string[] = ['dataprenotazione', 'oraprenotazione','datacontatto','codiceprestazione','idpaziente'];

  dataSource = new MatTableDataSource<Prenotazione>();

  ngOnInit(): void {
    this.servizioApi.getPrenotazioni().subscribe((lista: any) => {
      this.dataSource = lista.data;
      console.log(lista.data)
    },
      (error) => {
        console.error('Errore durante il recupero dei record', error);
      }
    );
  }

}

