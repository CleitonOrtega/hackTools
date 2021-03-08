import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { VerQuestionarioComponent } from './ver-questionario/ver-questionario.component';
import { ResponderQuestionarioComponent } from './responder-questionario/responder-questionario.component';
const routes: Routes = [
  {path: 'home',component: HomeComponent},
  {path: '', redirectTo:'home',pathMatch:'full'},
  {path: 'verQuestionario', component: VerQuestionarioComponent},
  {path: 'responderQuestionario', component: ResponderQuestionarioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
