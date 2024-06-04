import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatSliderModule } from '@angular/material/slider';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatTableModule } from '@angular/material/table';
import { MatSelectModule } from '@angular/material/select';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ListaComponent } from './lista/lista.component';
import { InserimentoComponent } from './inserimento/inserimento.component';
import { DatePipe } from '@angular/common';
import { PrenotazioneComponent } from './prenotazione/prenotazione.component';
import { NgxMaterialTimepickerModule } from 'ngx-material-timepicker';
import { ListaPazientiComponent } from './lista-pazienti/lista-pazienti.component';
import { MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
  declarations: [
    InserimentoComponent,
    ListaComponent,
    ListaPazientiComponent,
    PrenotazioneComponent,
    AppComponent
   ],
  imports: [
    MatSelectModule,
    MatFormFieldModule,
    BrowserModule,
    HttpClientModule,
    MatSelectModule,
    AppRoutingModule,
    MatSliderModule,
    MatIconModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatListModule,
    MatSidenavModule,
    MatToolbarModule,
    MatTableModule,
    NgxMaterialTimepickerModule,
    MatSelectModule,
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent],

})
export class AppModule { }
