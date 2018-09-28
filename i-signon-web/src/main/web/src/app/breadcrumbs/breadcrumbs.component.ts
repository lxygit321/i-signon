import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {filter, distinctUntilChanged, map} from 'rxjs/operators';
import {BreadcrumbModule} from 'primeng/breadcrumb';
import {MenuItem} from 'primeng/api';
import { ReportTitleService } from './../services/report-title.service';


@Component({
  selector: 'kr-breadcrumbs',
  templateUrl: './breadcrumb.component.html',
  styleUrls: ['./breadcrumb.component.scss']
})
export class BreadcrumbComponent implements OnInit {

  private reportTitleService: ReportTitleService;

  private startItems: MenuItem[] = [
    {
      label: 'Home',
      url: 'http://infozone',
      icon: 'pi pi-home',
      title: 'Infozone'
    },
    {
      label: 'Corporate Metadata',
      url: 'http://corporatemetadata',
      title: 'Corporate Metadata'
    },
    {
      label: 'I-Signon',
      title: 'I-Signon',
      url: '/'
    }
  ];

  breadcrumbs$ = this.router.events
    .pipe(filter(event => event instanceof NavigationEnd))
    .pipe(distinctUntilChanged())
    .pipe(map(event => this.buildBreadCrumb(this.activatedRoute.root, '', this.startItems)));

  // Build your breadcrumb starting with the root route of your current activated route

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router, private reportTitle: ReportTitleService) {

              this.reportTitleService = reportTitle;
  }


  ngOnInit() {
  }

  buildBreadCrumb(route: ActivatedRoute, url: string = '',
                  breadcrumbs: Array<MenuItem> = []): Array<MenuItem> {

    // --------------------------------------------------------------------
    // If no routeConfig is avalailable we are on the root path.
    // The root path has a label of "false" to indicate no breadcrumb
    // should be created.
    // --------------------------------------------------------------------

    const label = route.routeConfig ? route.routeConfig.data['breadcrumb'] : 'false';
    const path = route.routeConfig ? route.routeConfig.path : '';
    const icon = '';

    // -------------------------------------------------------
    // In the routeConfig the complete path is not available,
    // so we rebuild it each time
    // -------------------------------------------------------


    const nextUrl = `${url}${path}/`;
    const breadcrumb: MenuItem = {
      label: label,
      url: nextUrl,
      icon: icon
    };

    // --------------------------------------------------------------------
    // This section uses recursion to create the bookmark list that will
    // appear in the HTML page. If the breadcrumb has a label of "false",
    // then don't add the breadcrumb to the breadcrumb list.
    // --------------------------------------------------------------------

    const newBreadcrumbs = ('false' !== breadcrumb.label)
      ? [...breadcrumbs, breadcrumb]
      : [...breadcrumbs];


    // --------------------------------------------------------------------
    // This section checks to see if we are on our current path. If we are
    // not on our current path yet, then there will be more children to
    // look after, to build our breadcrumb.
    // --------------------------------------------------------------------

    if (route.firstChild) {

      return this.buildBreadCrumb(route.firstChild, nextUrl, newBreadcrumbs);
    }

    this.doPageTitle(route);

    return newBreadcrumbs;
  }

  private doPageTitle(route: ActivatedRoute): void {

    // --------------------------------------------------------------------
    // Setting the Page title. If no long title is provided, then the
    // breadcrumb is used as the page title. The page title also serves as
    // the browser tab label.
    // --------------------------------------------------------------------

    if (typeof route.routeConfig.data['longTitle'] === typeof undefined) {
      this.reportTitleService.updateReportTitle(route.routeConfig.data['breadcrumb']);

    }
    else {
      this.reportTitleService.updateReportTitle(route.routeConfig.data['longTitle']);
    }
  }
}
