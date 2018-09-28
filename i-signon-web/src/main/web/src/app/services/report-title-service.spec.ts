import { TestBed, inject } from '@angular/core/testing';

import { ReportTitleServiceService } from './report-title-service.service';

describe('ReportTitleServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReportTitleServiceService]
    });
  });

  it('should be created', inject([ReportTitleServiceService], (service: ReportTitleServiceService) => {
    expect(service).toBeTruthy();
  }));
});
