import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ProductListComponent} from './product/product-list/product-list.component';
import {ProductCreateComponent} from './product/product-create/product-create.component';
import {ProductEditComponent} from './product/product-edit/product-edit.component';
import {BenXeListComponent} from './ben-xe-list/ben-xe-list.component';
import {BenXeEditComponent} from './ben-xe-edit/ben-xe-edit.component';
import {BenXeCreateComponent} from './ben-xe-create/ben-xe-create.component';


const routes: Routes = [
  {
    path: 'product/list',
    component: ProductListComponent
  },
  {
    path: 'product/create',
    component: ProductCreateComponent
  }, {
    path: 'product/edit/:id',
    component: ProductEditComponent
  },
  {
    path: '',
    component: BenXeListComponent
  }, {
    path: 'ben-xe/edit/:id',
    component: BenXeEditComponent
  }, {
    path: 'ben-xe/create',
    component: BenXeCreateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
