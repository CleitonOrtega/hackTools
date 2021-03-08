import { Component, OnInit } from '@angular/core';
import { questionario } from '../model/questionario';
import { resposta } from '../model/resposta';
import { QuestionarioService } from '../service/questionario.service';
import { RespostaService } from '../service/resposta.service';

@Component({
  selector: 'app-ver-questionario',
  templateUrl: './ver-questionario.component.html',
  styleUrls: ['./ver-questionario.component.css']
})
export class VerQuestionarioComponent implements OnInit {

  Resposta: resposta = new resposta()
  listaResposta!: resposta[]

  Questionario: questionario = new questionario()
  listaQuestionario!: questionario[]

  teste: boolean = false
  constructor(
    private respostaService: RespostaService,
    private questionarioService: QuestionarioService
  ) { }

  ngOnInit() {
    window.scroll(0,0)

    this.findAllByQuestionario()
  }

  findAllByResposta(){
    this.respostaService.getAllByResposta().subscribe((resp: resposta[])=>{
      this.listaResposta = resp
    })
  }

  findAllByQuestionario(){
    this.questionarioService.getAllByQuestionario().subscribe((resp: questionario[])=>{
      this.listaQuestionario = resp
    })
  }

  identificarId(id: number){
    
    this.questionarioService.getQuestionarioById(id).subscribe((resp: questionario)=>{
      this.Questionario = resp
      this.listaResposta = this.Questionario.modelResposta
      if(this.listaResposta.length == 0){
        this.teste = true
      }else{
        this.teste = false
      }
    })
  }
  
}
