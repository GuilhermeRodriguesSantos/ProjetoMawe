import {HttpClientModule} from '@angular/common/http'
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { RodapeComponent } from './rodape/rodape.component';
import { SobreNosComponent } from './sobre-nos/sobre-nos.component';
import { ContatoComponent } from './contato/contato.component';
import { HomeComponent } from './home/home.component';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { LogarComponent } from './logar/logar.component';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { CategoriaComponent } from './categoria/categoria.component';
import { ProdutoComponent } from './produto/produto.component';
import { CasaComponent } from './casa/casa.component';
import { ModaComponent } from './moda/moda.component';
import { ArteComponent } from './arte/arte.component';
import { InfantilComponent } from './infantil/infantil.component';
import { PetComponent } from './pet/pet.component';
import { PapelariaComponent } from './papelaria/papelaria.component';
import { SaudeComponent } from './saude/saude.component';
import { CosmeticosComponent } from './cosmeticos/cosmeticos.component';
import { InicioEmpresaComponent } from './inicio-empresa/inicio-empresa.component';
import { CategoriaEditComponent } from './edit/categoria-edit/categoria-edit.component';
import { CategoriaDeleteComponent } from './delete/categoria-delete/categoria-delete.component';
import { ProdutosEditComponent } from './edit/produtos-edit/produtos-edit.component';
import { ProdutosApagarComponent } from './delete/produtos-apagar/produtos-apagar.component';
import { DoacaoComponent } from './doacao/doacao.component';
import { InicioUsuarioComponent } from './inicio-usuario/inicio-usuario.component';
import { Menu2Component } from './menu2/menu2.component';
import { Menu3Component } from './menu3/menu3.component';




@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    RodapeComponent,
    SobreNosComponent,
    ContatoComponent,
    HomeComponent,
    LogarComponent,
    CadastrarComponent,
    CategoriaComponent,
    ProdutoComponent,
    CasaComponent,
    ModaComponent,
    ArteComponent,
    InfantilComponent,
    PetComponent,
    PapelariaComponent,
    SaudeComponent,
    CosmeticosComponent,
    InicioEmpresaComponent,
    CategoriaEditComponent,
    CategoriaDeleteComponent,
    ProdutosEditComponent,
    ProdutosApagarComponent,
    DoacaoComponent,
    InicioUsuarioComponent,
    Menu2Component,
    Menu3Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [{
    provide: LocationStrategy,
    useClass: HashLocationStrategy
  }],
  bootstrap: [AppComponent]
}) 
export class AppModule { }
