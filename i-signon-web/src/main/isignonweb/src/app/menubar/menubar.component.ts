import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'kr-menubar',
  templateUrl: './menubar.component.html',
  styleUrls: ['./menubar.component.scss']
})
export class MenubarComponent implements OnInit {

	items: MenuItem[];

  constructor() { }

  ngOnInit() {
  	this.items = [
  		{
  			label: 'Register Profile',
  			routerLink: ['/profile']

  		},
  		{label: 'Confirm Signon Participation'},
  		{label: 'Release Families'},
  		{
  			label: 'Go To Release Cordination Services',
  			url: 'http://infozone/english/r2423153/dtim_gidt/dasd_dsda/pad_dap/rdots_slmire/rcdcat/index-e.asp'
  		}
  	];
  }

}
