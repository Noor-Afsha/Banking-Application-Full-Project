import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Account } from '../account';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent {

  id: number = 0;
  account: Account = new Account();

  constructor(
    private accountService: AccountService,
    private router: Router,
    private route:ActivatedRoute
  ) { }


  successMessage: string = "";
  errorMessage: string = "";

  
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.accountService.getAccountById(this.id).subscribe(data => {
      this.account = data;
    })
  }

  onSubmit() {
    if (this.isValidAmount(this.account.balance)) {
      this.accountService.withdrawBalance(this.id, this.account.balance).subscribe(data => {
        this.account = data;
        this.successMessage = "Withdraw successfully...."
        setTimeout(() => {
          this.router.navigate(['/accounts'])
        }, 1000);

      })
    } else {

      setTimeout(() => {
        // this.router.navigate(['/accounts'])
      },1000)
    }

  }

  isValidAmount(amount: number): boolean {
    return amount > 0 && amount < 100000000
  }
}