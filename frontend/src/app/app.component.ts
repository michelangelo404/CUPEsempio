import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angularclient';

  visibleLista = false;
  visibleInserimento = false;
  visiblePrenotazione = false;

  onPress(event: MouseEvent) {
    const paragraphText = (event.target as HTMLParagraphElement).textContent;
    if (paragraphText == 'Inserisci paziente') {
      this.visibleInserimento = !this.visibleInserimento;
      this.visiblePrenotazione = false
      this.visibleLista = false
    }
    if (paragraphText == 'Nuova prenotazione') {
      this.visiblePrenotazione = !this.visiblePrenotazione;
      this.visibleInserimento = false
      this.visibleLista = false
    }
    if (paragraphText == 'Lista prenotazioni') {
      this.visibleLista = !this.visibleLista;
      this.visiblePrenotazione = false
      this.visibleInserimento = false
    }
  }
}
