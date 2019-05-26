import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterIntoCourseComponent } from './register-into-course.component';

describe('RegisterIntoCourseComponent', () => {
  let component: RegisterIntoCourseComponent;
  let fixture: ComponentFixture<RegisterIntoCourseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterIntoCourseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterIntoCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
