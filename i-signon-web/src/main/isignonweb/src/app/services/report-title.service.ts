import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

// ----------------------------------------------------------------------------
// This piece of metadata makes the service available to all components in the
// application.
// ----------------------------------------------------------------------------

@Injectable({
  providedIn: 'root'
})

// -------------------------------
// The componet class declaration
// -------------------------------

export class ReportTitleService {

	private subject = new Subject<any>();

	updateReportTitle(mytext: string) {
		this.subject.next(mytext);
	}

	getReportTitle(): Observable<any> {
		return this.subject.asObservable();
	}

}
