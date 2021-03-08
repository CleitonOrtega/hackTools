import { Component, OnInit } from '@angular/core';
import { questionario } from '../model/questionario';
import { QuestionarioService } from '../service/questionario.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  Questionario: questionario = new questionario()

  constructor(
    private questionarioService: QuestionarioService 
  ) { }

  ngOnInit(){
    window.scroll(0,0)
  } 

  salvar(){
    this.questionarioService.post(this.Questionario).subscribe((resp: questionario)=> {
      this.Questionario = resp
      alert("Questionario criado com sucesso!")
      this.Questionario = new questionario()
    })
  }

}
