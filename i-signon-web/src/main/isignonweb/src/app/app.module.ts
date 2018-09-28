/*
--------------------------------------------------------------------------------------
Third-party Imports
--------------------------------------------------------------------------------------
*/

import { BrowserModule }            from '@angular/platform-browser';
import { NgModule }                 from '@angular/core';
import { BrowserAnimationsModule }  from '@angular/platform-browser/animations';
import { RouterModule }             from '@angular/router';
import { NgbModule }                from '@ng-bootstrap/ng-bootstrap';
// import { FlexLayoutModule }         from '@angular/flex-layout';
import { BreadcrumbModule}          from 'primeng/breadcrumb';
import { MenubarModule }            from 'primeng/menubar';
import { FormsModule,
         ReactiveFormsModule }      from '@angular/forms';
import { ListboxModule }            from 'primeng/listbox';
import { 
          MatButtonModule,
          MatMenuModule,
          MatToolbarModule,
          MatIconModule,
          MatCardModule,
          MatFormFieldModule,
          MatInputModule,
          MatDatepickerModule,
          MatDatepicker,
          MatNativeDateModule,
          MatRadioModule,
          MatSelectModule,
          MatOptionModule,
          MatSlideToggleModule,
          ErrorStateMatcher,
          ShowOnDirtyErrorStateMatcher,
          MAT_LABEL_GLOBAL_OPTIONS
        }                           from '@angular/material';

/*
--------------------------------------------------------------------------------------
Local Components
--------------------------------------------------------------------------------------
*/

import { AppComponent }             from './app.component';
import { AppRoutingModule }         from './app-routing.module';
import { BreadcrumbComponent }      from './breadcrumbs/breadcrumbs.component';
import { WETBannerComponent }       from './wet-banner/wet-banner.component';
import { ReportPageTitleComponent } from './report-page-title/report-page-title.component';
import { PageNotFoundComponent }    from './page-not-found/page-not-found.component';
import { HomeComponent }            from './home-component/home.component';
import { MainComponent }            from './main-component/main.component';
import { MenubarComponent }         from './menubar/menubar.component';
import { ProfileComponent }         from './profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    WETBannerComponent,
    BreadcrumbComponent,
    ReportPageTitleComponent,
    PageNotFoundComponent,
    HomeComponent,
    MainComponent,
    MenubarComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgbModule,
    BreadcrumbModule,
    MenubarModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRadioModule,
    MatSelectModule,
    MatOptionModule,
    MatSlideToggleModule,
    ListboxModule,    
  ],
  exports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRadioModule,
    MatSelectModule,
    MatOptionModule,
    MatSlideToggleModule,
    ListboxModule
  ],
  providers: [
    { provide: MAT_LABEL_GLOBAL_OPTIONS, useValue: {float: 'auto'}},
    { provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
