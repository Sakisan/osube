# CoffeeScript
(($) ->
  $(document).ready ->
    $("span.timeago").timeago()
    group_events()
    $('.event').removeClass('hidden')
    $('footer').addClass('hidden')

  stack = []

  epic = $('#epic')
  epic.click ->
    if(epic.hasClass('active'))
      epic.removeClass('active')
      $("#events").html(stack.pop())
    else
      epic.addClass('active')
      stack.push($("#events").html())
      $(".epic-factor-1").remove();
      $("li.header+li.header").prev().remove()

  group_events = () ->
    events = $('.event')
    time = ''
    for event in events
        next = $(event).find('.timeago').text()
        if next != time
          $('<li class="header"><h2 class="text-center wow fadeInUp">'+next.replace(' ago','&nbsp;ago')+'</h2></li>').insertBefore(event)
          time = next

  the_end = 'end'
) jQuery