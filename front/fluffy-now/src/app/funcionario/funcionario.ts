import { Cargo } from "../cargo/cargo";
import { Departamento } from "../departamento/departamento";
export interface Funcionario {
  idFuncionario: number;
  nome: string;
  cpf: string;
  data_nascimento: string;
  salario: string;

  cargo: Cargo;
  departamento: Departamento;
}
