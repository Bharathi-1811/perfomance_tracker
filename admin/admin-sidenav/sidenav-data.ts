import { AdminNavbarData } from "./sidenav-helper";

export const navbarData:AdminNavbarData[] = [
    {
        routeLink: 'dashboardsection',
        icon: 'bi bi-calendar2',
        label: 'Dashboard'
    },
    {
        routeLink: 'managetrainee',
        icon: "bi bi-person-fill-add",
        label: 'AddTrainee'

    },
    {
        routeLink: 'managebatch',
        icon: "bi bi-person-fill-add",
        label: 'Batch'

    },
    {
        routeLink: 'managetopic',
        icon: "bi bi-journal-plus",
        label: 'Topic',

    },
    {
        routeLink: 'managebtcombination',
        icon: 'bi bi-passport',
        label: 'Batch and Topic '

    },
    {
        routeLink: 'managebatchtraineecombo',
        icon: 'bi bi-person-video3',
        label: 'Batch and Trainee '

    },
    {
        routeLink: 'manageupcomingtest',
        icon: 'bi bi-megaphone',
        label: 'Upcoming Announcements'

    },
    {
        routeLink: 'manageresult',
        icon: 'bi bi-clipboard2-data',
        label: 'Result Management '

    },

];