import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFlashcardSetComponent } from './create-flashcard-set.component';

describe('CreateFlashcardSetComponent', () => {
  let component: CreateFlashcardSetComponent;
  let fixture: ComponentFixture<CreateFlashcardSetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateFlashcardSetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateFlashcardSetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
