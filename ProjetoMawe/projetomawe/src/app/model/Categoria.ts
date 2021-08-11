import { produto } from "./produto"
import { Usuario } from "./Usuario"

export class Categoria {

    public id: number
    public segmentoEmpresa: string
    public materialReutilizado: string
    public materialBiodegradavel: string
    public produto: produto[]
    public empresaCriadora: Usuario
}