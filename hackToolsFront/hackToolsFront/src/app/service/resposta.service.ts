import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { resposta } from '../model/resposta';

@Injectable({
  providedIn: 'root'
})
export class RespostaService {

  constructor(
    private http: HttpClient
  ) { }

    getAllByResposta() : Observable<resposta[]>{
      return this.http.get<resposta[]>('http://localhost:8080/respostas/buscarRespostas')
    }

    post(respostaEnviada : resposta):Observable<resposta>{
      return this.http.post<resposta>('http://localhost:8080/respostas', respostaEnviada)
    }
}
