import { Component, OnInit } from '@angular/core';
import { questionario } from '../model/questionario';
import { resposta } from '../model/resposta';
import { QuestionarioService } from '../service/questionario.service';
import { RespostaService } from '../service/resposta.service';

@Component({
  selector: 'app-responder-questionario',
  templateUrl: './responder-questionario.component.html',
  styleUrls: ['./responder-questionario.component.css']
})
export class ResponderQuestionarioComponent implements OnInit {

  Resposta: resposta = new resposta()
  listaResposta!: resposta[]

  Questionario: questionario = new questionario()
  listaQuestionario!: questionario[]

  constructor(
    private respostaService: RespostaService,
    private questionarioService: QuestionarioService
  ) { }

  ngOnInit() {
    window.scroll(0, 0)

    this.getUserLocation()
    this.findAllByResposta()
    this.findAllByQuestionario()
  }

  findAllByResposta() {
    this.respostaService.getAllByResposta().subscribe((resp: resposta[]) => {
      this.listaResposta = resp
    })
  }

  findAllByQuestionario() {
    this.questionarioService.getAllByQuestionario().subscribe((resp: questionario[]) => {
      this.listaQuestionario = resp
    })
  }

  salvar(id: number) {
    this.questionarioService.getQuestionarioById(id).subscribe((resp: questionario) => {
      this.Resposta.questionario = resp
      this.getUserLocation()
      this.respostaService.post(this.Resposta).subscribe((resp: resposta) => {
        this.Resposta = resp
        this.Resposta = new resposta()
        this.Questionario = new questionario()
      })

      alert("Questionario respondido com sucesso!")
    })
  }

  
  mostrarCoordenadas(position: any) {
    navigator.geolocation.getCurrentPosition(position)
    console.log(position.coords.latitude, position.coords.longitude)
  }

  getUserLocation() {
    if (navigator.geolocation) {
     navigator.geolocation.getCurrentPosition(position => {
          this.Resposta.lat = position.coords.latitude
          this.Resposta.longi = position.coords.longitude
          console.log(position.coords.latitude)
          console.log(position.coords.longitude)
       });
 }else {
    console.log("User not allow")
 }
}
}
