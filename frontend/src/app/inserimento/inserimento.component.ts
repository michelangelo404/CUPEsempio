import { Component } from '@angular/core';
import { ServizioApiService } from '../servizi/servizio-api.service';
import { DatePipe } from '@angular/common';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-inserimento',
  templateUrl: './inserimento.component.html',
  styleUrls: ['./inserimento.component.css']
})

export class InserimentoComponent{

  myForm: FormGroup;
  records: any;

  constructor(
    private servizioApi: ServizioApiService,
    private datePipe: DatePipe,
    private formBuilder: FormBuilder) {
      this.myForm = this.formBuilder.group({
        nome: ['', Validators.required],
        cognome: ['', [Validators.required]],
        dataNascita: ['', [Validators.required]],
      });
    }

  inserisciPaziente() {
    var dataNascita = this.myForm.value.dataNascita;
    this.myForm.setValue({
      nome: this.myForm.value.nome,
      cognome: this.myForm.value.cognome,
      dataNascita: this.datePipe.transform(this.myForm.value.dataNascita, "yyyyMMdd")
    });
    this.servizioApi.addPaziente(this.myForm.value).subscribe((ritorno: any[]) => {
      console.log(ritorno);
    });
    this.myForm.setValue({
      nome: this.myForm.value.nome,
      cognome: this.myForm.value.cognome,
      dataNascita: dataNascita
    });
  }

}
