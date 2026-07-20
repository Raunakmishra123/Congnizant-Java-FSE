course.model.ts
----------------
export interface Course {
  id: number;
  name: string;
  code: string;
  credits: number;
  gradeStatus: 'passed' | 'failed' | 'pending';
  enrolled?: boolean;
}


home.component.ts
------------------
import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit, OnDestroy {
  coursesavailable = 12;
  enrolledcount = 3;
  gpa = 3.8;

  portalname = 'Student Course Portal';
  isportalactive = true;
  message = '';
  searchterm = '';

  onenrollclick() {
    this.message = 'Enrollment opened!';
  }

  ngOnInit() {
    console.log('home component loaded');
  }

  ngOnDestroy() {
    console.log('home component destroyed');
  }
}


course-card.component.ts
-------------------------
import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Course } from '../../models/course.model';
import { HighlightDirective } from '../../directives/highlight.directive';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, HighlightDirective, CreditLabelPipe],
  templateUrl: './course-card.component.html',
  styleUrl: './course-card.component.css'
})
export class CourseCardComponent implements OnChanges {
  @Input() course!: Course;
  @Output() enrollrequested = new EventEmitter<number>();

  isexpanded = false;

  ngOnChanges(changes: SimpleChanges) {
    if (changes['course']) {
      console.log('course changed', changes['course'].previousValue, changes['course'].currentValue);
    }
  }

  onenrollclick() {
    this.enrollrequested.emit(this.course.id);
  }

  toggleexpanded() {
    this.isexpanded = !this.isexpanded;
  }

  get bordercolor() {
    if (this.course.gradeStatus === 'passed') return 'green';
    if (this.course.gradeStatus === 'failed') return 'red';
    return 'grey';
  }

  get cardclasses() {
    return {
      'card--enrolled': !!this.course.enrolled,
      'card--full': this.course.credits >= 4,
      'expanded': this.isexpanded
    };
  }
}


course-list.component.ts
-------------------------
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Course } from '../../models/course.model';
import { CourseCardComponent } from '../../components/course-card/course-card.component';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css'
})
export class CourseListComponent implements OnInit {
  isloading = true;

  courses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Database Systems', code: 'CS102', credits: 3, gradeStatus: 'pending' },
    { id: 3, name: 'Operating Systems', code: 'CS103', credits: 4, gradeStatus: 'failed' },
    { id: 4, name: 'Web Development', code: 'CS104', credits: 3, gradeStatus: 'passed' },
    { id: 5, name: 'Computer Networks', code: 'CS105', credits: 2, gradeStatus: 'pending' }
  ];

  selectedcourseid: number | null = null;

  ngOnInit() {
    setTimeout(() => {
      this.isloading = false;
    }, 1500);
  }

  onenroll(courseid: number) {
    console.log('enrolling in course: ' + courseid);
    this.selectedcourseid = courseid;
  }

  trackbycourseid(index: number, course: Course) {
    return course.id;
  }
}


highlight.directive.ts
-----------------------
import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {
  @Input() appHighlight = 'yellow';

  constructor(private el: ElementRef<HTMLElement>) {}

  @HostListener('mouseenter')
  onmouseenter() {
    this.el.nativeElement.style.backgroundColor = this.appHighlight;
  }

  @HostListener('mouseleave')
  onmouseleave() {
    this.el.nativeElement.style.backgroundColor = '';
  }
}


credit-label.pipe.ts
---------------------
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'creditLabel',
  standalone: true
})
export class CreditLabelPipe implements PipeTransform {
  transform(credits: number | null | undefined) {
    if (credits === null || credits === undefined || credits === 0) return 'No Credits';
    if (credits === 1) return '1 Credit';
    return credits + ' Credits';
  }
}