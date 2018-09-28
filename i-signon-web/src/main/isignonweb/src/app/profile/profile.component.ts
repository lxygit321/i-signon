import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';

import { ReleaseFamily } from '../models/ReleaseFamily';


@Component({
  selector: 'kr-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
	
	releaseFamilyList: ReleaseFamily[] = [
		{id: '1', year: '2018', name: '2018JAN', description: 'January 2018 Pre-match'},
		{id: '2', year: '2018', name: '2018FEB', description: 'February 2018 T1'},
		{id: '3', year: '2019', name: '2019EFIL', description: '2019 EFile / Netfile'},
		{id: '4', year: '2019', name: '2019JAN', description: 'January 2019 Pre-match'},
		{id: '5', year: '2019', name: '2019FEB', description: 'Febraury 2019 T1'},
		{id: '6', year: '2019', name: '2019SPR', description: 'Spring 2019'},
		{id: '7', year: '2019', name: '2018JUL', description: 'Summer 2019'}
	];

	profileFormGroup: FormGroup;

	constructor(private fb: FormBuilder){}

	ngOnInit() {
		this.profileFormGroup = this.fb.group({
			releaseFamily: ['',[
				Validators.required
			]]
		});
	}

}