import { produto } from "./produto"
import { Usuario } from "./Usuario"

export class Categoria {

    public id: number
    public segmentoEmpresa: string
    public materialReutilizado: String
    public materialBiodegradavel: String
    public produto: produto []
    public empresaCriadora: Usuario
}