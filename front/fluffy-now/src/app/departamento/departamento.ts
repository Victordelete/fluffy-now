import { Empresa } from "../empresa/empresa";

export interface Departamento {
  idDepartamento: number;
  nome: string;
  descricao: string;
  empresa: Empresa;
}
