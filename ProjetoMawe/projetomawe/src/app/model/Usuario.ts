import { produto } from "./produto"

export class Usuario{
    public id: number
    public nome: string
    public email:string
    public senha: string
    public tipoUsuario: string
    public endereco: string
    public produtosCadastrados: produto[]
}