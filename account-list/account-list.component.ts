import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Account } from '../account';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent {

  //creating an object
  accounts: Account[] = [];

  constructor(
    private accountService: AccountService,
    private router: Router
  ) { }


  ngOnInit() {
    this.getAccounts();
  }

  deposit(id: number) {
    this.router.navigate(['/deposit', id])
  }
  getAccounts() {
    this.accountService.getAllAccounts().subscribe(data => {
      this.accounts = data;
    })
  }
  withdraw(id: number) {
    this.router.navigate(['/withdraw', id])
  }

  delete(id: number) {
    this.accountService.deleteAccount(id).subscribe(data => {
      console.log(data);
      this.getAccounts();
    })
  }

  view(id:number){
    this.router.navigate(['/account-details',id])
  }
}
