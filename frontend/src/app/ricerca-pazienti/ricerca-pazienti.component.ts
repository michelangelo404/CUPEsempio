import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';


@Component({
  selector: 'RicercaPazienti',
  templateUrl: './ricerca-pazienti.component.html',
  styleUrls: ['./ricerca-pazienti.component.css'],
  standalone: true,
  imports: [
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    MatDialogModule,
  ],
})
export class RicercaPazientiComponent implements OnInit {

  submitForm() {
    throw new Error('Method not implemented.');
  }

  form: FormGroup;
  items: any[] = [];
  visible = false;
  show = false;

  constructor(private formBuilder: FormBuilder,
    private route: ActivatedRoute,) {
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.show = true;
  }

  close() {
    this.show = false;
  }

surname: any;
name: any;
fiscalCode : any;

}

