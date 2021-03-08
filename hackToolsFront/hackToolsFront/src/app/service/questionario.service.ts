import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { questionario } from '../model/questionario';

@Injectable({
  providedIn: 'root'
})
export class QuestionarioService {

  constructor(
    private http: HttpClient
  ) { }

  getAllByQuestionario() : Observable<questionario[]>{
    return this.http.get<questionario[]>('http://localhost:8080/questionario/buscarTodos')
  }

  getQuestionarioById(id: number): Observable<questionario>{
    return this.http.get<questionario>(`http://localhost:8080/questionario/id.${id}`)
  }

  post(questionarioEnviado : questionario):Observable<questionario>{
    return this.http.post<questionario>('http://localhost:8080/questionario', questionarioEnviado)
  }

}
