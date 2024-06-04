import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServizioApiService {

  apiUrlPaziente = 'http://localhost:8080/paziente';
  apiUrlPrenotazione = 'http://localhost:8080/prenotazione';

  constructor(private http: HttpClient) { }

  getPrenotazioni(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrlPrenotazione+"/lista")
  }

  // getPosts(): Observable<any[]> {
  //   return this.http.get<any[]>(`${this.apiUrl}/posts`);
  // }

  getPaziente(nome: any,cognome: any,codiceFiscale: any): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrlPaziente}/cerca?firstName=${nome}&lastName=${cognome}&codiceFiscale=${codiceFiscale}`);
  }

  // getPostById(id: number): Observable<any> {
  //   return this.http.get<any>(`${this.apiUrl}/posts/${id}`);
  // }

   addPrenotazione(post: any): Observable<any> {
     return this.http.post<any>(`${this.apiUrlPrenotazione}/inserisci`, post);
  }

   addPaziente(post: any): Observable<any> {
     return this.http.post<any>(`${this.apiUrlPaziente}/inserisci`, post);
  }

  // updatePost(id: number, post: any): Observable<any> {
  //   return this.http.put<any>(`${this.apiUrl}/posts/${id}`, post);
  // }

  // deletePost(id: number): Observable<any> {
  //   return this.http.delete<any>(`${this.apiUrl}/posts/${id}`);
  // }

}
