import { SignonDate } from './SignonDate';

export interface ReleaseFamily {
	id: string;
	year: number;
	name: string;
	description: string;
	startDate: string;
	endDate: string;
	signonDates: SignonDate[];
}