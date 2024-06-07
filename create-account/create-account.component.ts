import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { timeout } from 'rxjs';
import { Account } from '../account';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent {

//creating an object of account
  account:Account=new Account();

  accountCreate=false;
constructor(
  private accountService:AccountService,
  private router:Router
){}


onSubmit(){
  this.saveAccount();
}

saveAccount(){
  this.accountService.addAccount(this.account).subscribe(data=>{
    console.log(data);
    this.accountCreate=true;
    setTimeout(( )=>{
      this.goToAccountList();
    },1000);
  })
}
//after submitting the form , will re-direct on aacountList page
goToAccountList(){
this.router.navigate(['/accounts'])
}
}
