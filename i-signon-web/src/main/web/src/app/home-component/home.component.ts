import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
// import { ReportTitleService } from './../services/report-title-service';
// import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'kr-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
	
	url: string;
	title: string;

//	constructor(private reportTitleService: ReportTitleService, private route: ActivatedRoute){}

	constructor(){}

    ngOnInit() {
//		this.reportTitleService.updateReportTitle("Home");
//		this.url =  this.route.snapshot.url.join('/');
//		this.title = this.route.snapshot.data['title'];
	}
}
