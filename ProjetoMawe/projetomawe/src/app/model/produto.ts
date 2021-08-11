import { Categoria } from "./Categoria";
import { Usuario } from "./Usuario";

export class produto{

    public id: number;
    public nome: string;
    public preco: number;
    public descricao: string;
    public quantidade: number;
    public url: string;
    public categoria: Categoria
    public empresaCriadora: Usuario


}