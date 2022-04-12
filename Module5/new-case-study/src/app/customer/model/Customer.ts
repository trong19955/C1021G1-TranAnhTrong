import {CustomerTypeList} from './CustomerTypeList';

export class Customer{
  private _idCustomer: number;
  private _nameCustomer: string;
  private _age:number;
  private _emailCustomer:string;
  private _phoneCustomer:string;
  private _gender:string;
  private _address:string;
  private _customerType: CustomerTypeList;


  constructor(idCustomer: number, nameCustomer: string, age: number, emailCustomer: string, phoneCustomer: string, gender: string, address: string, customerType: CustomerTypeList) {
    this._idCustomer = idCustomer;
    this._nameCustomer = nameCustomer;
    this._age = age;
    this._emailCustomer = emailCustomer;
    this._phoneCustomer = phoneCustomer;
    this._gender = gender;
    this._address = address;
    this._customerType = customerType;
  }

  get idCustomer(): number {
    return this._idCustomer;
  }

  set idCustomer(value: number) {
    this._idCustomer = value;
  }

  get nameCustomer(): string {
    return this._nameCustomer;
  }

  set nameCustomer(value: string) {
    this._nameCustomer = value;
  }

  get age(): number {
    return this._age;
  }

  set age(value: number) {
    this._age = value;
  }

  get emailCustomer(): string {
    return this._emailCustomer;
  }

  set emailCustomer(value: string) {
    this._emailCustomer = value;
  }

  get phoneCustomer(): string {
    return this._phoneCustomer;
  }

  set phoneCustomer(value: string) {
    this._phoneCustomer = value;
  }

  get gender(): string {
    return this._gender;
  }

  set gender(value: string) {
    this._gender = value;
  }

  get address(): string {
    return this._address;
  }

  set address(value: string) {
    this._address = value;
  }

  get customerType(): CustomerTypeList {
    return this._customerType;
  }

  set customerType(value: CustomerTypeList) {
    this._customerType = value;
  }
}
