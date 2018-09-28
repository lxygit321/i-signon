import { Component,  OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ReportTitleService } from './../services/report-title.service';
import { Title } from '@angular/platform-browser';


@Component({
  selector: 'kr-report-page-title',
  template: `
 	 <div class="container-fluid">
 	 	<h1>{{reportTitle}}</h1>
	</div>
  `,
  styles: [`
  `]
})

export class ReportPageTitleComponent implements  OnInit {
	reportTitle: string;
	subscription: Subscription;


 constructor(private reportTitleService: ReportTitleService, private browserTitle: Title) {
 	this.subscription =this.reportTitleService.getReportTitle().subscribe(this.successHandler);
}
 	// ------------------------------------
 	// Callback for successful execution.
 	// ------------------------------------

 	successHandler = (text) => {
 		 this.reportTitle = 'I-Signon - ' + text;
 		 this.browserTitle.setTitle(this.reportTitle);
 	};

 ngOnInit() {
 	
 }

 ngOnDestroy() {
 	this.subscription.unsubscribe();
 }

}
