'use strict';

new TypeIt('.typeItText',{
    loop: true,
    speed: 50
    }

    )
    .move(-12)
    .type('POSTBOX에 오신 ')
    .move(null, {to: 'END'})
    .type('🤗🤗🤗')
    .pause(2000)
    .delete()
    .type('많이 부족하지만!', {speed: 200})
    .pause(1000)
    .delete()
    .type('꾸준히 공부하는 개발자가 되겠습니다', {speed: 200})
    .pause(3000)
    .delete()
    .type('모두 건강 챙기시고 행복하세요!❤️❤️❤️', {speed: 600})
    .pause(3000)
    .delete()
    .go();

// POSTBOX에 오신 면접관님들 환영합니다. 많이 부족하지만 꾸준히 공부하는 개발자가 되겠습니다. 모두 건강 챙기시고 행복하세요!🤗🤗🤗
