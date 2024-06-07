import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from '../account';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-deposite',
  templateUrl: './deposite.component.html',
  styleUrls: ['./deposite.component.css']
})
export class DepositeComponent {

  id: number = 0;
  account: Account = new Account();

  constructor(
    private accountService: AccountService,
    private route: ActivatedRoute,
    private router: Router
  ) { }


  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.accountService.getAccountById(this.id).subscribe(data => {
      this.account = data;
    })
  }

  successMessage: string = "";
  errorMessage: string = "";

  onSubmit() {
    if (this.isValidAmount(this.account.balance)) {
      this.accountService.depositBalance(this.id, this.account.balance).subscribe(data => {
        this.account = data;
        this.successMessage = "Deposit successfully...."
        setTimeout(() => {
          this.router.navigate(['/accounts'])
        }, 1000);

      })
    } else {
      this.errorMessage = "invalid amount.....please enter a valid amount"

      setTimeout(() => {
        this.errorMessage = ""
        // this.router.navigate(['/accounts'])
      },1000)
    }

  }

  isValidAmount(amount: number): boolean {
    return amount > 0 && amount < 100000000
  }
}
