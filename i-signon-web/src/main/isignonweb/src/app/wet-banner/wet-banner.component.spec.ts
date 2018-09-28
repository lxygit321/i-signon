import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WETBannerComponent } from './wet-banner.component';

describe('WETBannerComponent', () => {
  let component: WETBannerComponent;
  let fixture: ComponentFixture<WETBannerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WETBannerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WETBannerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
