import { resposta } from "./resposta"

export class questionario{
    public idQuestionario:number
    public titulo: string
    public primeiraPergunta: string
    public segundaPergunta: string
    public usuario: string
    public modelResposta: resposta[]
}