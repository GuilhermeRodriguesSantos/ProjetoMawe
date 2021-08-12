import { DoacaoComponent } from './doacao/doacao.component';
import { SobreNosComponent } from './sobre-nos/sobre-nos.component';
import { ContatoComponent } from './contato/contato.component';
import { HomeComponent } from './home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LogarComponent } from './logar/logar.component';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { InicioComponent } from './inicio/inicio.component';
import { CategoriaComponent } from './categoria/categoria.component';
import { ProdutoComponent } from './produto/produto.component';
import { CasaComponent } from './casa/casa.component';
import { CosmeticosComponent } from './cosmeticos/cosmeticos.component';
import { ModaComponent } from './moda/moda.component';
import { ArteComponent } from './arte/arte.component';
import { InfantilComponent } from './infantil/infantil.component';
import { PetComponent } from './pet/pet.component';
import { PapelariaComponent } from './papelaria/papelaria.component';
import { SaudeComponent } from './saude/saude.component';
import { InicioEmpresaComponent } from './inicio-empresa/inicio-empresa.component';
import { CategoriaEditComponent } from './edit/categoria-edit/categoria-edit.component';
import { CategoriaDeleteComponent } from './delete/categoria-delete/categoria-delete.component';
import { ProdutosEditComponent } from './edit/produtos-edit/produtos-edit.component';
import { ProdutosApagarComponent } from './delete/produtos-apagar/produtos-apagar.component';


const routes: Routes = [
  {path:'', redirectTo: 'home', pathMatch: 'full'},
  {path:"home", component: HomeComponent },
  {path:"contato", component:ContatoComponent },
  {path:"sobre-nos", component:SobreNosComponent },
  {path: "Logar" , component: LogarComponent},
  {path: "Cadastrar", component: CadastrarComponent},
  {path: "Inicio", component: InicioComponent},
  {path: 'categoria', component: CategoriaComponent},
  {path: "Produto", component: ProdutoComponent},
  {path: "casa", component: CasaComponent},
  {path: "moda", component: ModaComponent},
  {path: "arte", component: ArteComponent},
  {path: "infantil", component: InfantilComponent},
  {path: 'pet', component: PetComponent},
  {path: 'papelaria', component: PapelariaComponent},
  {path: "saude", component: SaudeComponent},
  {path: "cosmeticos", component: CosmeticosComponent},
  {path: "Inicio-empresa", component:InicioEmpresaComponent},
  {path: "Editar/:id", component: CategoriaEditComponent},
  {path: "Deletar/:id", component: CategoriaDeleteComponent},
  {path: "produtoed/:id", component: ProdutosEditComponent},
  {path: "produtodl/:id", component:ProdutosApagarComponent  },
  {path: "doacao", component: DoacaoComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
