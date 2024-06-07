import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { AccountListComponent } from './account-list/account-list.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { DepositeComponent } from './deposite/deposite.component';
import { WithdrawComponent } from './withdraw/withdraw.component';

const routes: Routes = [
  {
    path: 'accounts', component: AccountListComponent
  },
  {
    path: 'create-account', component: CreateAccountComponent
  },
  {
    path: 'deposit/:id', component: DepositeComponent
  },
  {
    path: '', redirectTo: 'accounts', pathMatch: 'full'
  },
  {
    path: 'withdraw/:id', component: WithdrawComponent
  },
  {
    path:'account-details/:id',component:AccountDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
