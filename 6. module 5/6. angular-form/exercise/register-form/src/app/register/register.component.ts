import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  userForm: FormGroup;

  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.userForm = this._formBuilder.group({
      email: ['',[Validators.required,Validators.email]],
      password: ['',[Validators.required,Validators.minLength(6)]],
      cPassword:['',[Validators.required,Validators.minLength(6)]],
      country:['',[Validators.required]],
      age:['',[Validators.required, Validators.min(18)]],
      gender:['Male',[Validators.required]],
      phoneNumber:['',[Validators.required,Validators.pattern('^\\+84\\d{9,10}$')]]
    })
  }

  onSubmit() {
    console.log(this.userForm.value)
  }
}
