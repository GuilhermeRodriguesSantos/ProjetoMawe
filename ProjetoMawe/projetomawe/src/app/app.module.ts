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
import { LogarComponent } from './logar/logar.component';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { InicioComponent } from './inicio/inicio.component';
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
    InicioComponent,
    CategoriaComponent,
    ProdutoComponent,
    CasaComponent,
    ModaComponent,
    ArteComponent,
    InfantilComponent,
    PetComponent,
    PapelariaComponent,
    SaudeComponent,
    CosmeticosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
