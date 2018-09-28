import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';

import { ReleaseFamily } from '../models/ReleaseFamily';


@Component({
  selector: 'kr-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
	
	families: ReleaseFamily[];

	profileForm: FormGroup;

	constructor(private fb: FormBuilder){}

	ngOnInit() {
		this.profileForm = this.fb.group(
			{
				releaseFamily: ['',[
					Validators.required
				]],
				component: ['',[
					Validators.required
				]],
				participation: ['',[
					Validators.required
				]]
			}
		);
	}


	/*
	-----------------------------------------------------------------------
	Getters to enable easier access to the form control values
	-----------------------------------------------------------------------
	*/

	get email() {
		return this.profileForm.get('email');
	}

	get component() {
		return this.profileForm.get('component');
	}

	get participation() {
		return this.profileForm.get('participation');
	}

	}