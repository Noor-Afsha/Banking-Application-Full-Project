import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from './account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(
    private httpClient: HttpClient
  ) { }

  // private baseUrl = "http://localhost:9001/accounts/getAllAccounts";
  // private baseUrl1 = "http://localhost:9001/accounts/add";
  // private baseUrl2 = "http://localhost:9001/accounts/getById";
  private baseUrl = "http://localhost:9001/accounts";




  getAllAccounts(): Observable<Account[]> {
    return this.httpClient.get<Account[]>(`${this.baseUrl}/getAllAccounts`);
  }
  addAccount(account: Account): Observable<Account> {
    return this.httpClient.post<Account>(`${this.baseUrl}/add`, account);
  }
  getAccountById(id: number): Observable<Account> {
    return this.httpClient.get<Account>(`${this.baseUrl}/getById/${id}`);
  }
  depositBalance(id: number, balance: number): Observable<Account> {
    const request = { balance };
    return this.httpClient.put<Account>(`${this.baseUrl}/deposit/${id}`, request);
  }
  withdrawBalance(id: number, balance: number): Observable<Account> {
    const request = { balance };
    return this.httpClient.put<Account>(`${this.baseUrl}/withdraw/${id}`, request);
  }
  deleteAccount(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/delete/${id}`);
  }
  
}
