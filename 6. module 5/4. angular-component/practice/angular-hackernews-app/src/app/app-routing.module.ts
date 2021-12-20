import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ArticleComponent} from './article/article.component';
import {AddArticleComponent} from './add-article/add-article.component';


const routes: Routes = [
  {path: '', component: ArticleComponent},
  {path: 'home', component: ArticleComponent},
  {path: 'add', component: AddArticleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
