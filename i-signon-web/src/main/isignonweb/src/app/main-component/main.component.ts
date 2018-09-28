import { Component, OnInit } from '@angular/core';
import { ReportTitleService } from '../services/report-title.service';

@Component({
  selector: 'kr-main-component',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  constructor(private reportTitle: ReportTitleService) { 
  	this.reportTitle.updateReportTitle("Welcom Page");
  }

  ngOnInit() {
  	
  }

}
