import { Funcionario } from "../funcionario/funcionario";

export interface RegPonto {
  idRegPonto: number;
  dataPonto: string;
  local: string;
  distance: number;

  funcionario: Funcionario;
}
